import React from 'react';
import { ReviewCard } from '../components/ReviewCard';
import { useAuth } from '../context/AuthContext';

export const MyReviewsPage = () => {
  const { user } = useAuth();

  // Mock reviews data - replace with actual data
  const reviews = [
    {
      id: '1',
      movieId: '1',
      userId: '1',
      rating: 5,
      content: 'Mind-bending masterpiece that keeps you guessing...',
      createdAt: '2024-03-15',
      userName: user?.name || '',
      movieTitle: 'Inception',
      moviePoster: 'https://images.unsplash.com/photo-1440404653325-ab127d49abc1',
    },
    // Add more reviews
  ];

  return (
    <div className="min-h-screen bg-gray-900 pt-20">
      <div className="mx-auto max-w-7xl px-4 py-12">
        <h1 className="mb-8 text-3xl font-bold text-white">My Reviews</h1>
        
        {reviews.length > 0 ? (
          <div className="grid grid-cols-1 gap-6 md:grid-cols-2">
            {reviews.map((review) => (
              <ReviewCard key={review.id} review={review} />
            ))}
          </div>
        ) : (
          <div className="flex min-h-[400px] items-center justify-center rounded-lg bg-gray-800">
            <div className="text-center">
              <p className="text-xl text-gray-400">You haven't written any reviews yet.</p>
              <p className="mt-2 text-gray-500">Start sharing your thoughts on movies!</p>
            </div>
          </div>
        )}
      </div>
    </div>
  );
};