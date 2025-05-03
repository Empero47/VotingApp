import { useState } from "react";
import api from "../../../../api/axios";
import "../Login/login.css";
import { useAuth } from "../../../../context/AuthContext";
import { Link } from "react-router-dom";

export default function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const { login } = useAuth();

  const handleLogin = async () => {
    const res = await api.post("/auth/login", null, {
      params: { email, password },
    });
    login(res.data);
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
