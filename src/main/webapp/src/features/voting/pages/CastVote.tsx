import { useCandidates } from '../hooks/useCandidates';
import CandidateCard from '../components/CandidateCard';
import api from '../../../api/axios';

export default function CastVote() {
    const { candidates, loading } = useCandidates();

    const handleVote = async (candidateId: string) => {
        await api.post('/votes', { candidateId });
        alert('VoteModel cast successfully!');
    };

    if (loading) return <p>Loading candidates...</p>;

    return (
        <div>
            <h2>Cast Your Vote</h2>
            {candidates.map((c: any) => (
                <CandidateCard
                    key={c.id}
                    id={c.id}
                    name={c.name}
                    party={c.party}
                    onVote={handleVote}
                />
            ))}
        </div>
    );
}
