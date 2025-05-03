import { Link } from "react-router-dom";
import "../pages/home.css";

export default function Home() {
  return (
    <div className="home">
      <div className="header">
        <Link to="/">VotingApp</Link>
      </div>

      <div className="hero-text">
        <p className="hero__text_small">Clean & Friendly</p>
        <h1 className="hero_text_big">Online voting web application</h1>

        <div className="hero_middle">
          <p>
            Vote instantly, securely, and make every decision count — from local
            polls to national issues.
          </p>
        </div>

        <div className="hero_links">
          <Link to="/login" className="login">
            Login
          </Link>
          <Link to="/register" className="signup">
            Sign up
          </Link>
        </div>
      </div>
    </div>
  );
}
