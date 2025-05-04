import {useState} from "react";
import api from "../../../../api/axios";
// @ts-ignore
import "./register.css";
import {useAuth} from "../../../../context/AuthContext";
import {Link} from "react-router-dom";

export default function Register() {
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const {login} = useAuth();

    const handleRegister = async () => {
        const res = await api.post("/auth/register", {name, email, password});
        login(res.data);
    };

    return (
        <>
            <header>
                <Link to="/">VotingApp</Link>
            </header>

            <div className="register_wrapper">
                <div className="register-parent">
                    <h2>Register</h2>
                    <input
                        placeholder="Name"
                        className="name"
                        onChange={(e) => setName(e.target.value)}
                    /><input
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
                    <button onClick={handleRegister} className="register_btn">
                        Register
                    </button>
                </div>
            </div>
        </>
    );
}
