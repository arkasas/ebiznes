import React, { useState } from 'react';
import { Button } from 'react-bootstrap';
import useOrder from "../hook/useOrder";
import useAuth from "../hook/useAuth";

export default function AddToOrderButton(props) {

    const [isLoading, setLoading] = useState(false);
    const product = props.product;
    const { addToOrder } = useOrder(product.ID);
    const { currentUserValue } = useAuth();

    async function handleClick(e) {
        e.preventDefault();
        setLoading(true);
        await addToOrder(currentUserValue().ID)
            .then((data) => {
                console.log(data)
                setLoading(false);
            })
    }

    return (
        <Button onClick={handleClick} disabled={isLoading}>{isLoading ? "Czekaj" : "Kup"}&nbsp;</Button>
    );

}
