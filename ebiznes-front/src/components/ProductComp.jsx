import React from 'react';
import {Button, Col} from 'react-bootstrap';
import AddToOrderButton from "./AddToOrderButton";

export class ProductComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            product: this.props.product,
            cannotAddToCart: !!this.props.cannotAddToCart

        };
    }

    render() {
        const { product, cannotAddToCart } = this.state;

        return (
            <tr>
                <td>{product.Name}</td>
                <td>{product.Description}</td>
                <td>{product.Price} zł</td>
                <td>
                    {cannotAddToCart ? null : <AddToOrderButton product={product}></AddToOrderButton>}
                </td>
            </tr>
        );
    }
}
