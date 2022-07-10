import { env } from '../env.ts';
import useServerService from './useServerService';

function useLogin() {
    const [request] = useServerService()

    function signMeIn(user) {
        console.log(user);

        return request('POST', `${env.serverUrl}/auth/signin`, user);
    }

    function logMeIn(user) {
        console.log(user);
        return request('POST', `${env.serverUrl}/auth/login`, user);
    }

    return { signMeIn, logMeIn };

}

export default useLogin;
