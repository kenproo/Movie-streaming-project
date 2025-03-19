import { Link, useNavigate } from "react-router-dom";
import style from "../styles/Navbar.module.scss";
import Logo from "../assets/Logo.png";
import {FaSearch} from "react-icons/fa";
const NavBar = () => {
  const navigate = useNavigate();
  return (
    <div className={style.navBar}>
      <img src={Logo} alt="Logo" onClick={() => navigate("/")} />
      <div className={style.nav_link}>
        <ul>
          <li>
            <Link to="/">Phim Moi </Link>
          </li>
          <li>
            <Link to="/list/phim-le">Phim le </Link>
          </li>
          <li>
            <Link to="/list/phim-le">Phim le </Link>
          </li>
          <li>
            <Link to="/list/phim-le">Phim le </Link>
          </li>
          <li>
            <Link to="/list/phim-le">Phim le </Link>
          </li>
          <li>
            <Link to="/list/phim-le">Phim le </Link>
          </li>
        </ul>
        <div className={style.search_box}>
          <input type="text" placeholder="Tìm kiếm phim..." />
          <span className={style.search_icon}><i><FaSearch />
          </i></span>
        </div>
        <button className ={style.btn_login} onClick ={() => navigate("/login")}> Đăng nhập</button>
      </div>
    </div>
  );
};

export default NavBar;
