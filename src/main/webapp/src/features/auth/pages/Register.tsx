import { useState } from 'react';
import api from '../../../api/axios';
import { useAuth } from '../../../context/AuthContext';

export default function Register() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const { login } = useAuth();

    const handleRegister = async () => {
        const res = await api.post('/auth/register', null, {
            params: { email, password }
        });
        login(res.data);
    };

    return (
        <div>
            <h2>Register</h2>
            <input placeholder="Email" onChange={(e) => setEmail(e.target.value)} />
            <input placeholder="Password" type="password" onChange={(e) => setPassword(e.target.value)} />
            <button onClick={handleRegister}>Register</button>
        </div>
    );
}
