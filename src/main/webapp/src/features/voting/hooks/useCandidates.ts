import { useEffect, useState } from 'react';
import api from '../../../api/axios';

export const useCandidates = () => {
    const [candidates, setCandidates] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        api.get('/candidates')
            .then(res => setCandidates(res.data))
            .finally(() => setLoading(false));
    }, []);

    return { candidates, loading };
};
