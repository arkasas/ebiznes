import React, { useEffect, useState } from 'react';
import {Table} from 'react-bootstrap';
import {ProductComponent} from "../components/ProductComp";
import useOrder from "../hook/useOrder";
import PayButton from "../components/PayButton";
import useAuth from "../hook/useAuth";

function Order() {
    const { getOrder } = useOrder();
    const [isLoading, setLoading] = useState(true);
    const [items, setProducts] = useState([])
    const { currentUserValue } = useAuth();

    async function getAll() {
        await getOrder(currentUserValue().ID)
            .then((data) => {
                console.log(data)
                setLoading(false);
                setProducts([data]);
                setProducts([...items, ...data]);
            })
    }

    useEffect(() => {
        if (isLoading) {
            getAll();
        }
    }, [isLoading])

    if (!!isLoading) {
        return <p>Loading</p>
    }

    return (
        <div style={{ padding: 30 }}>
            <h2>Cart</h2>
            <Table striped bordered hover>
                <thead>
                <tr>
                    <th>Product name</th>
                    <th>Description</th>
                    <th>Price</th>
                </tr>
                </thead>
                <tbody>
                {items.map(product =>
                    <ProductComponent key={product.ID} product={product.Product} cannotAddToCart="true"></ProductComponent>
                )}
                </tbody>
            </Table>
            <p>Sum: {items.reduce(function (prev, next) {
                return prev + next.Product.Price;
            }, 0)}</p>
            {items.length > 0 ? <PayButton></PayButton> : null}
        </div>
    )
}

export default Order;
