import useAuth from "../hook/useAuth";
import {useEffect} from "react";

export default function Logout(props) {

    const {isLoggedIn, logout} = useAuth();

    useEffect(() => {
        console.log("-------------------------------------- logger effect ----------------------------------------");
        console.log('logout logged in: ', isLoggedIn)

        if (!!isLoggedIn) {
            logout();
        } else {
            console.log('logger setting loading on false');
            props.callback(new Date());
        }

    }, [isLoggedIn])

    return (
        <div>
            <h2>Wylogowano</h2>
        </div>
    )
}
