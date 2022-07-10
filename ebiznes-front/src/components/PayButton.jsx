import React, { useState } from 'react';
import { Button } from 'react-bootstrap';
import useOrder from "../hook/useOrder";
import {useNavigate} from "react-router-dom";
import usePayment from "../hook/usePayment";

export default function PayButton(props) {

    let navigate = useNavigate();
    const [isLoading, setLoading] = useState(false);
    const [orderAndPay] = usePayment();

    async function handleClick(e) {
        e.preventDefault();
        setLoading(true);
        await orderAndPay(2)
            .then(() => {
                setLoading(false);
                navigate("finish")
            })
    }

    return (
        <Button onClick={handleClick}>{isLoading ? "Wait" : "Pay"}</Button>
    );

}
