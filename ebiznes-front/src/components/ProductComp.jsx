import React from 'react';
import AddToOrderButton from "./AddToOrderButton";

export class ProductComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            product: this.props.product,
            isVisible: !!this.props.isVisible

        };

        console.log(this.state.isVisible)
    }

    render() {
        const { product, isVisible } = this.state;

        return (
            <tr>
                <td>{product.Name}</td>
                <td>{product.Description}</td>
                <td>{product.Price} zł</td>
                <td>
                    {!isVisible ? null : <AddToOrderButton product={product}></AddToOrderButton>}
                </td>
            </tr>
        );
    }
}
