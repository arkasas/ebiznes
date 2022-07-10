import React, { useEffect, useState } from 'react';
import {ListGroup, Row, Table} from 'react-bootstrap';
import useProduct from "../hook/useProduct";
import { Col } from 'react-bootstrap';
import { Button } from 'react-bootstrap';
import {ProductComponent} from "../components/ProductComp";

function Products() {
    const [getProducts] = useProduct();
    const [products, setProducts] = useState([])
    const [isLoading, setLoading] = useState(true);

    useEffect(() => {
        async function getAll() {
            await getProducts()
                .then((data) => {
                    console.log(data)
                    setLoading(false);
                    setProducts([...products, ...data]);
                })
        }

        if (isLoading) {
            getAll();
        }
    }, [isLoading, getProducts, products])

    if (!!isLoading) {
        return (
            <div>
                <h2>Products</h2>
                Ładowanie
            </div>
        )
    }

    return (
        <div style={{ padding: 30 }}>
            <h2>Products</h2>
            <Table striped bordered hover>
                <thead>
                <tr>
                    <th>Product name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                {products.map(product =>
                    <ProductComponent product={product}></ProductComponent>
                )}
                </tbody>
            </Table>
        </div>
    )
}

export default Products;
