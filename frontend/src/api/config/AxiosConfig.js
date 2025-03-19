import axios from "axios";

// Tạo instance của Axios với cấu hình mặc định
const axiosInstance = axios.create({
  baseURL: "http://localhost:8080/identity_service", 
  timeout: 10000, 
  headers: {
    "Content-Type": "application/json", 
  },
});


axiosInstance.interceptors.response.use(function(response) {
return response.data;

})


export default axiosInstance;
