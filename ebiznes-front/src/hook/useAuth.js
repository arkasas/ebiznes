import { useEffect, useState } from 'react';
import { BehaviorSubject } from 'rxjs';
import { NotificationManager } from 'react-notifications';

var currentUserSubject;
var currentUser;

function useAuth() {
    const [isLoggedIn, setIsLoggedIn] = useState(false)

    useEffect(() => {
        if (!isLoggedIn) {
            if (!!localStorage.getItem('currentUser')) {
                currentUserSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('currentUser')));
                currentUser = currentUserSubject.asObservable();
                setIsLoggedIn(true);
                console.log('\tlogged ');
            } else {
                console.log("brak user");
            }

            console.log(currentUser);
        } else {
            console.log('auth, logged in', isLoggedIn);
        }

    }, [isLoggedIn])

    function login(user) {
        if (!!user) {
            if (!currentUserSubject) {
                console.log('\tauth login proceed');
                localStorage.setItem('currentUser', JSON.stringify(user));
                currentUserSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('currentUser')));
                currentUserSubject.next(user);
                setIsLoggedIn(true);
            } else {
                NotificationManager.info("Alredy logged", 'Error!');
            }
        } else {
            NotificationManager.error("No user data to log in", 'Error!');
        }
    }

    function currentUserValue() {
        console.log(currentUserSubject);

        return currentUserSubject ? currentUserSubject.value : null;
    }

    function logout() {
        localStorage.removeItem('currentUser');
        currentUserSubject.next(null);
        setIsLoggedIn(false)
    }

    return { isLoggedIn, login, logout, currentUserValue };
}

export default useAuth;
