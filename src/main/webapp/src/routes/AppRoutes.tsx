import { Routes, Route, Navigate } from 'react-router-dom';
import Login from '../features/auth/pages/Login';
import Register from '../features/auth/pages/Register';
import CastVote from '../features/voting/pages/CastVote';
import ViewResults from '../features/voting/pages/ViewResults';
import AdminPanel from '../features/admin/pages/AdminPanel';
import ProtectedRoute from '../components/ProtectedRoute';

export default function AppRoutes() {
    return (
        <Routes>
            <Route path="/" element={<Navigate to="/register" />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />

            {/* Protected Routes */}
            <Route element={<ProtectedRoute />}>
                <Route path="/vote" element={<CastVote />} />
                <Route path="/results" element={<ViewResults />} />
                <Route path="/admin" element={<AdminPanel />} />
            </Route>
        </Routes>
    );
}
