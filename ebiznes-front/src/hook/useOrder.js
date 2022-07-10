import { useState } from 'react';
import { env } from '../env.ts';

import useServerService from './useServerService';

function useOrder(pid) {
    const [request] = useServerService();
    const [productID, setProductId] = useState(pid);

    function getOrder(uid) {
        return request('GET', `${env.serverUrl}/order/${uid}`);
    }

    function addToOrder(uid) {
        console.log({ ProductID: productID, UserID: uid })
        return request('POST', `${env.serverUrl}/order`, { ProductId: productID, UserId: uid });
    }

    return {productID, setProductId, getOrder, addToOrder};
}

export default useOrder;
