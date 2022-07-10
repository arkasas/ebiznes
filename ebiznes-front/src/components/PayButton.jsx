import React, { useState } from 'react';
import { Button } from 'react-bootstrap';
import {useNavigate} from "react-router-dom";
import usePayment from "../hook/usePayment";
import useAuth from "../hook/useAuth";

export default function PayButton() {

    let navigate = useNavigate();
    const [isLoading, setLoading] = useState(false);
    const [orderAndPay] = usePayment();
    const { currentUserValue } = useAuth();

    async function handleClick(e) {
        e.preventDefault();
        setLoading(true);
        await orderAndPay(currentUserValue().ID)
            .then(() => {
                setLoading(false);
                navigate("finish")
            })
    }

    return (
        <Button onClick={handleClick}>{isLoading ? "Wait" : "Pay"}</Button>
    );

}
