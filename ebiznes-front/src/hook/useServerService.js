function useServerService() {
    async function request(method, url, data) {

        console.log(url)
        console.log(JSON.stringify(data))
        try {
             return await fetch(url, {
                method: method,
                body: JSON.stringify(data),
                headers: {
                    'Content-Type': 'application/json',
                }
            })
                .then((res) => {
                    return res.json()
                })
                .then((res) => {
                    if (res.message) {
                        console.info(res.message);
                    }

                    return res;
                })
                .catch(error => {
                    console.log(error)
                    console.error(`error: ${error.message}`);
                })

        } catch (err) {
            console.error(err)
        }
    }

    return [request];
}

export default useServerService;
