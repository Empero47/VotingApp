import { Navigate, Outlet } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';

export default function ProtectedRoute() {
    const { token } = useAuth();

    if (!token) {
        // Redirect to login page if no token
        return <Navigate to="/login" />;
    }

    return <Outlet />;
}
