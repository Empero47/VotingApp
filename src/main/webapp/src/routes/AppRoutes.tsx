import { Routes, Route, Navigate } from 'react-router-dom';
import Login from '../features/auth/pages/Login/Login';
import Register from '../features/auth/pages/Register/Register';
import CastVote from '../features/voting/pages/CastVote';
import ViewResults from '../features/voting/pages/ViewResults';
import AdminPanel from '../features/admin/pages/AdminPanel';
import ProtectedRoute from '../components/ProtectedRoute';
import Home from '../pages/Home';

export default function AppRoutes() {
    return (
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />

            {/* Protected Routes */}
            <Route element={<ProtectedRoute />}>
                <Route path="/voteModel" element={<CastVote />} />
                <Route path="/results" element={<ViewResults />} />
                <Route path="/admin" element={<AdminPanel />} />
            </Route>
        </Routes>
    );
}
