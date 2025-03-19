import React, { useState } from "react";
import "../styles/SignupForm.scss";
import { register } from "../api/auth/Authenticate";
import { useNavigate } from "react-router-dom";
import { FaUser, FaLock, FaLockOpen } from "react-icons/fa";
import { MdOutlineMailOutline } from "react-icons/md";

function RegisterForm() {
  const [formData, setFormData] = useState({
    username: "",
    password: "",
    firstname: "",
    lastname: "",
    email: "",
  });
  const [isShowPassword, setIsShowPassword] = useState(false);
  const [formErrors, setFormErrors] = useState({});
  const navigate = useNavigate();

  const [touchedFields, setTouchedFields] = useState({});
  const validateField = (name, value) => {
    let errorMsg = "";

    switch (name) {
      case "username":
        if (!value.trim()) errorMsg = "Tên đăng nhập không được để trống";
        break;

      case "email":
        if (!value.trim()) errorMsg = "Email không được để trống";
        else if (!/\S+@\S+\.\S+/.test(value)) errorMsg = "Email không hợp lệ";
        break;

      case "password":
        if (!value) errorMsg = "Mật khẩu không được để trống";
        else if (value.length < 6)
          errorMsg = "Mật khẩu phải có ít nhất 6 ký tự";
        break;

      case "firstname":
        if (!value.trim()) errorMsg = "First Name không được để trống";
        break;

      case "lastname":
        if (!value.trim()) errorMsg = "Last Name không được để trống";
        break;

      default:
        break;
    }

    setFormErrors((prevErrors) => ({
      ...prevErrors,
      [name]: errorMsg,
    }));
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({ ...prevData, [name]: value }));
    if (touchedFields[name]) {
      validateField(name, value);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!validateField(formData)) return;

    try {
      const response = await register(formData);
      if (response.result.token) {
        localStorage.setItem("token", response.result.token);
      }
      navigate("/");
    } catch (err) {
      console.error("Lỗi đăng ký:", err);
    }
  };
  const handleBlur = (e) => {
    const { name, value } = e.target;
    setTouchedFields((prev) => ({ ...prev, [name]: true })); // Đánh dấu input đã được nhấn
    validateField(name, value); // Kiểm tra lỗi khi rời khỏi input
  };

  return (
    <div className="container">
      <div className="wrapper">
        <form onSubmit={handleSubmit} className="form-box-signup">
          <h1>Register</h1>

          <div className="input-box">
            <input
              type="text"
              id="username"
              name="username"
              value={formData.username}
              onChange={handleChange}
              onBlur={handleBlur}
              required
            />
            <label>Username</label>
            {formErrors.username && (
              <p className="error">{formErrors.username}</p>
            )}
            <i>
              <FaUser className="icon" />
            </i>
          </div>

          <div className="input-box">
            <input
              type={!isShowPassword ? "text" : "password"}
              id="password"
              name="password"
              required
              value={formData.password}
              onChange={handleChange}
              onBlur={handleBlur}
            />
            <label>Password</label>
            <i
              onClick={() => setIsShowPassword(!isShowPassword)}
              style={{ cursor: "pointer" }} // Cách dùng trực tiếp
            >
              {!isShowPassword ? <FaLockOpen /> : <FaLock />}
            </i>
            {formErrors.password && (
              <p className="error">{formErrors.password}</p>
            )}
          </div>

          <div className="input-box">
            <input
              type="email"
              className="input-email"
              value={formData.email}
              onChange={handleChange}
              onBlur={handleBlur}
              name="email"
              required
            />
            <label className="email">Email</label>
            <i>
               <MdOutlineMailOutline />
            </i>
            {formErrors.email && <p className="error">{formErrors.email}</p>}
          </div>

          {/* First Name */}
          <div className="input-box">
            <input
              type="text"
              id="firstname"
              name="firstname"
              value={formData.firstname}
              onBlur={handleBlur}
              onChange={handleChange}
              required
            />
            <label>First Name</label>

            {formErrors.firstname && (
              <p className="error">{formErrors.firstname}</p>
            )}
          </div>

          {/* Last Name */}
          <div className="input-box">
            <input
              type="text"
              id="lastname"
              name="lastname"
              value={formData.lastname}
              onChange={handleChange}
              onBlur={handleBlur}
              required
            />
            <label className="lastname">Last Name</label>
            {formErrors.lastname && (
              <p className="error">{formErrors.lastname}</p>
            )}
          </div>

          {/* Submit Button */}
          <button type="submit" className="btn">
            Register
          </button>
        </form>
      </div>
    </div>
  );
}

export default RegisterForm;
