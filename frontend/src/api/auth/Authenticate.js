import axios from "../config/AxiosConfig";

const BASE_URL = "/auth"
export const login = (credential) =>{
    return  axios.post(`${BASE_URL}/token`, credential);

}
export const introspect = (token) => {
   return axios.post(`${BASE_URL}/introspect`, token);

}
export const register = (credential) =>{

    return axios.post(`${BASE_URL}/register`, credential)
}