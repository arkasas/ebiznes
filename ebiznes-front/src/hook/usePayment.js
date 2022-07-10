import { env } from '../env.ts';
import useServerService from './useServerService';

function usePayment() {
    const [request] = useServerService()

    function orderAndPay(uid) {
        return request('POST', `${env.serverUrl}/payment/${uid}`);
    }

    return [orderAndPay];
}

export default usePayment;
