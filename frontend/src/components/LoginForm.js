import React, { useState } from "react";
import style from "../styles/LoginForm.module.scss";
import { login } from "../api/auth/Authenticate";
import { Link, useNavigate } from "react-router-dom";
import { FaUser, FaLock, FaLockOpen } from "react-icons/fa";

const Login = () => {
  const [formData, setFormData] = useState({ username: "", password: "" });
  const [error, setError] = useState("");
  const [isLoading, setIsLoading] = useState(false);
  const [isShowPassword, setIsShowPassword] = useState(false);
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({ ...prevData, [name]: value }));
  };

  const handleLogin = async (e) => {
    e.preventDefault();
    if (!formData.username || !formData.password) {
      setError("Vui lòng nhập đầy đủ thông tin");
      return;
    }
    setIsLoading(true);
    setError("");
    try {
      const response = await login(formData);
      if (response.result.token) {
        localStorage.setItem("token", response.result.token);
      }
      if (response.result.role === "admin") {
        navigate("/admin");
      } else {
        navigate("/");
      }
    } catch (err) {
      setError("Tài khoản hoặc mật khẩu không hợp lệ");
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div className={style.container}>
      <div className={style.wrapper}>
        <span className={style.bg_animate}></span>
        <div className={style.form_box_login}>
          <h1>Login</h1>
          {error && <p className={style.error_submit}>{error}</p>}
          <form>
            <div className={style.input_box}>
              <input
                type="text"
                name="username"
                required
                onChange={handleChange}
                value={formData.username}
              />
              <label>Username</label>
              <i>
                <FaUser className="icon" />
              </i>
            </div>
            <div className={style.input_box}>
              <input
                type={!isShowPassword ? "password" : "text"}
                name="password"
                required
                onChange={handleChange}
                value={formData.password}
              />
              <label>Password</label>
              <i
                onClick={() => setIsShowPassword(!isShowPassword)}
                style={{ cursor: "pointer" }} // Cách dùng trực tiếp
              >
                {isShowPassword ? <FaLockOpen /> : <FaLock />}
              </i>
            </div>
            <button type="submit" onClick={handleLogin} className={style.btn}>
              Login
            </button>
            <div className={style.logreg_link}>
              <p>
                Don't have an account? <Link to="/signup">Sign up</Link>
              </p>
            </div>
          </form>
        </div>
        <div className={style.infor_text_login}>
          <h1>Welcome my channel</h1>
        </div>
      </div>
    </div>
  );
};

export default Login;
