import { useState } from "react";
import api from "../../../../api/axios";
// import "../Login/login.css";
// @ts-ignore
import "./login.css";
import { useAuth } from "../../../../context/AuthContext";
import { Link } from "react-router-dom";

export default function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const { login } = useAuth();

  const handleLogin = async () => {
    try {
      const res = await api.post("/auth/login", { email, password });
      login(res.data);
    } catch (error) {
      console.error("Login failed:", error);
    }
  };


  return (
    <>
      <header>
        <Link to="/">VotingApp</Link>
      </header>

      <div className="login_wrapper">
        <div className="login-parent">
          <h2>Login</h2>
          <input
            placeholder="Email"
            className="e_mail"
            onChange={(e) => setEmail(e.target.value)}
          />
          <input
            placeholder="Password"
            type="password"
            className="password"
            onChange={(e) => setPassword(e.target.value)}
          />
          <button onClick={handleLogin} className="login_btn">
            Login
          </button>
        </div>
      </div>
    </>
  );
}
