import React, { useEffect, useState } from 'react';
import { Button } from 'react-bootstrap';
import { Link, useLocation, useNavigate } from "react-router-dom";
import jwt from 'jwt-decode'
import useAuth from "../hook/useAuth";


export default function Profile() {

    const { isLoggedIn, login, currentUserValue } = useAuth();
    const [isLoading, setLoading] = useState(true);
    const search = useLocation().search;
    const navigate = useNavigate();

    useEffect(() => {
        console.log("-------------------------------------- logger effect ----------------------------------------");
        console.log('logger logged in: ', isLoggedIn)
        console.log('logger is loading: ', isLoading)

        if (!isLoggedIn) {

            const query = new URLSearchParams(search);
            const token = query.get('token')
            if(token){
                let user = jwt(token);
                user.token = token;
                console.log(user);

                if (!!user) {
                    login(user);
                    navigate('/logged', {replace: false});
                }
            }

        } else {
            console.log('logger setting loading on false');
            setLoading(false);
        }

    }, [isLoggedIn])

    return (
        <div>
            <h2>Zalogowano: {currentUserValue() ? currentUserValue().Username : "No name"}</h2>
        </div>
    )
}
