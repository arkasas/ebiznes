import { env } from '../env.ts';
import useServerService from './useServerService';

function useProduct() {
    const [request] = useServerService()

    function getProducts() {
        return request('GET', `${env.serverUrl}/products`);
    }

    return [getProducts];
}

export default useProduct;
