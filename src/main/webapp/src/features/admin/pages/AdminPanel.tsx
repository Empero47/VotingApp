import { useState, useEffect } from 'react';
import api from '../../../api/axios';

export default function AdminPanel() {
    const [candidates, setCandidates] = useState([]);

    useEffect(() => {
        api.get('/admin/candidates')
            .then(res => setCandidates(res.data));
    }, []);

    const handleDeleteCandidate = async (id: string) => {
        await api.delete(`/admin/candidates/${id}`);
        setCandidates(candidates.filter(c => c.id !== id));
    };

    return (
        <div>
            <h2>Admin Panel</h2>
            <h3>Candidates</h3>
            <ul>
                {candidates.map((candidate: any) => (
                    <li key={candidate.id}>
                        {candidate.name} ({candidate.party})
                        <button onClick={() => handleDeleteCandidate(candidate.id)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}
