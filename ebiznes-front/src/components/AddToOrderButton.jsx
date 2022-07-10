import React, { useState } from 'react';
import { Button } from 'react-bootstrap';
import useOrder from "../hook/useOrder";

export default function AddToOrderButton(props) {

    const [isLoading, setLoading] = useState(false);
    const product = props.product;
    const { addToOrder } = useOrder(product.ID);

    async function handleClick(e) {
        e.preventDefault();
        setLoading(true);
        await addToOrder(2)
            .then((data) => {
                console.log(data)
                setLoading(false);
            })
    }

    return (
        <Button onClick={handleClick} disabled={isLoading}>{isLoading ? "Czekaj" : "Kup"}&nbsp;</Button>
    );

}
