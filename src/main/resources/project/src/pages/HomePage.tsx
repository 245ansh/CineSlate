import React from 'react';
import { SearchBar } from '../components/SearchBar';
import { MovieCard } from '../components/MovieCard';
import { ReviewCard } from '../components/ReviewCard';

const SAMPLE_MOVIES = [
  {
    id: '1',
    title: 'Inception',
    posterUrl: 'https://images.unsplash.com/photo-1440404653325-ab127d49abc1',
    year: 2010,
    rating: 4.8,
    overview: 'A thief who steals corporate secrets...',
  },
  // Add more sample movies
];

const SAMPLE_REVIEWS = [
  {
    id: '1',
    movieId: '1',
    userId: '1',
    rating: 5,
    content: 'Mind-bending masterpiece that keeps you guessing...',
    createdAt: '2024-03-15',
    userName: 'John Doe',
    movieTitle: 'Inception',
    moviePoster: 'https://images.unsplash.com/photo-1440404653325-ab127d49abc1',
  },
  // Add more sample reviews
];

export const HomePage = () => {
  const isAuthenticated = false; // Replace with actual auth state

  return (
    <div className="min-h-screen bg-gray-900">
      <div className="relative">
        <div className="absolute inset-0 bg-gradient-to-r from-purple-900/20 to-blue-900/20" />
        <div className="absolute inset-0 bg-[url('https://images.unsplash.com/photo-1536440136628-849c177e76a1')] bg-cover bg-center bg-no-repeat opacity-10" />
        <div className="relative mx-auto max-w-7xl px-4 py-32">
          <div className="flex flex-col items-center gap-8 text-center">
            <h1 className="text-4xl font-bold text-white md:text-6xl">
              Discover & Review Movies
            </h1>
            <p className="max-w-2xl text-lg text-gray-300">
              Join our community of movie enthusiasts. Rate, review, and create
              your personal movie collections.
            </p>
            <SearchBar />
          </div>
        </div>
      </div>

      <div className="mx-auto max-w-7xl px-4 py-12">
        <section className="mb-12">
          <h2 className="mb-6 text-2xl font-bold text-white">Trending Movies</h2>
          <div className="grid grid-cols-1 gap-6 sm:grid-cols-2 lg:grid-cols-4">
            {SAMPLE_MOVIES.map((movie) => (
              <MovieCard key={movie.id} movie={movie} />
            ))}
          </div>
        </section>

        <section>
          <h2 className="mb-6 text-2xl font-bold text-white">
            {isAuthenticated ? 'Your Recent Reviews' : 'Recent Reviews'}
          </h2>
          <div className="grid grid-cols-1 gap-6 md:grid-cols-2">
            {SAMPLE_REVIEWS.map((review) => (
              <ReviewCard key={review.id} review={review} />
            ))}
          </div>
        </section>
      </div>
    </div>
  );
}