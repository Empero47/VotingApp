import { useState } from 'react';
import api from '../../../api/axios';
import { useAuth } from '../../../context/AuthContext';

export default function Login() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const { login } = useAuth();

    const handleLogin = async () => {
        const res = await api.post('/auth/login', null, {
            params: { email, password }
        });
        login(res.data);
    };

    return (
        <div>
            <h2>Login</h2>
            <input placeholder="Email" onChange={(e) => setEmail(e.target.value)} />
            <input placeholder="Password" type="password" onChange={(e) => setPassword(e.target.value)} />
            <button onClick={handleLogin}>Login</button>
        </div>
    );
}
