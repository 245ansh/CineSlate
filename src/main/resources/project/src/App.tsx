import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { Navbar } from './components/Navbar';
import { Footer } from './components/Footer';
import { HomePage } from './pages/HomePage';
import { MovieDetails } from './pages/MovieDetails';
import { LoginPage } from './pages/LoginPage';
import { RegisterPage } from './pages/RegisterPage';
import { ReviewForm } from './pages/ReviewForm';
import { ReviewDetails } from './pages/ReviewDetails';
import { ProfilePage } from './pages/ProfilePage';
import { MyReviewsPage } from './pages/MyReviewsPage';
import { MyListsPage } from './pages/MyListsPage';
import { AuthProvider } from './context/AuthContext';

function App() {
  return (
    <AuthProvider>
      <Router>
        <div className="flex min-h-screen flex-col bg-gray-900">
          <Navbar />
          <main className="flex-1">
            <Routes>
              <Route path="/" element={<HomePage />} />
              <Route path="/movie/:id" element={<MovieDetails />} />
              <Route path="/login" element={<LoginPage />} />
              <Route path="/register" element={<RegisterPage />} />
              <Route path="/movie/:movieId/review" element={<ReviewForm />} />
              <Route path="/review/:id" element={<ReviewDetails />} />
              <Route path="/profile" element={<ProfilePage />} />
              <Route path="/my-reviews" element={<MyReviewsPage />} />
              <Route path="/my-lists" element={<MyListsPage />} />
            </Routes>
          </main>
          <Footer />
        </div>
      </Router>
    </AuthProvider>
  );
}

export default App;