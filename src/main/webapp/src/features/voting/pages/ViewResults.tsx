import { useEffect, useState } from 'react';
import api from '../../../api/axios';

export default function ViewResults() {
    const [results, setResults] = useState([]);

    useEffect(() => {
        api.get('/votes/results').then(res => setResults(res.data));
    }, []);

    return (
        <div>
            <h2>Election Results</h2>
            <ul>
                {results.map((r: any) => (
                    <li key={r.candidateId}>
                        {r.candidateName} ({r.party}) - {r.totalVotes} votes
                    </li>
                ))}
            </ul>
        </div>
    );
}
