type Props = {
    id: string;
    name: string;
    party: string;
    onVote: (id: string) => void;
};

export default function CandidateCard({ id, name, party, onVote }: Props) {
    return (
        <div style={{ border: '1px solid gray', padding: 12, margin: 8 }}>
            <h3>{name}</h3>
            <p>Party: {party}</p>
            <button onClick={() => onVote(id)}>Vote</button>
        </div>
    );
}
