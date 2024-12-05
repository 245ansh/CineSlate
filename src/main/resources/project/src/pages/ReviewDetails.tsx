import React, { useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { Star, Edit2, Trash2, User } from 'lucide-react';
import { useAuth } from '../context/AuthContext';

export const ReviewDetails = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const { user } = useAuth();
  const [isEditing, setIsEditing] = useState(false);
  const [editedReview, setEditedReview] = useState({
    rating: 5,
    content: 'Mind-bending masterpiece that keeps you guessing until the very end. The visuals are stunning, and the plot is intricately woven. Christopher Nolan has outdone himself with this film.',
  });

  // Mock review data - replace with actual data fetching
  const review = {
    id,
    userId: '1',
    movieId: '1',
    rating: 5,
    content: 'Mind-bending masterpiece that keeps you guessing until the very end. The visuals are stunning, and the plot is intricately woven. Christopher Nolan has outdone himself with this film.',
    createdAt: '2024-03-15',
    userName: 'John Doe',
    movieTitle: 'Inception',
    moviePoster: 'https://images.unsplash.com/photo-1440404653325-ab127d49abc1',
  };

  const handleDelete = () => {
    // Implement delete logic
    navigate('/my-reviews');
  };

  const handleUpdate = (e: React.FormEvent) => {
    e.preventDefault();
    // Implement update logic
    setIsEditing(false);
  };

  const isOwner = user?.id === review.userId;

  return (
    <div className="min-h-screen bg-gray-900 pt-20">
      <div className="mx-auto max-w-4xl px-4 py-12">
        <div className="overflow-hidden rounded-lg bg-gray-800 shadow-xl">
          <div className="relative h-48 bg-purple-900">
            <div className="absolute inset-0">
              <img
                src={review.moviePoster}
                alt={review.movieTitle}
                className="h-full w-full object-cover opacity-50"
              />
              <div className="absolute inset-0 bg-gradient-to-t from-gray-800 to-transparent" />
            </div>
          </div>

          <div className="p-6">
            <div className="mb-6 flex items-center justify-between">
              <div className="flex items-center gap-4">
                <div className="rounded-full bg-gray-700 p-2">
                  <User className="h-6 w-6 text-gray-300" />
                </div>
                <div>
                  <h3 className="font-medium text-white">{review.userName}</h3>
                  <p className="text-sm text-gray-400">{review.createdAt}</p>
                </div>
              </div>

              {isOwner && !isEditing && (
                <div className="flex gap-2">
                  <button
                    onClick={() => setIsEditing(true)}
                    className="rounded-full bg-gray-700 p-2 text-gray-300 hover:bg-gray-600"
                  >
                    <Edit2 className="h-5 w-5" />
                  </button>
                  <button
                    onClick={handleDelete}
                    className="rounded-full bg-red-900/30 p-2 text-red-400 hover:bg-red-900/50"
                  >
                    <Trash2 className="h-5 w-5" />
                  </button>
                </div>
              )}
            </div>

            <h2 className="mb-4 text-2xl font-bold text-white">{review.movieTitle}</h2>

            {isEditing ? (
              <form onSubmit={handleUpdate} className="space-y-6">
                <div>
                  <label className="mb-2 block text-sm text-gray-300">Rating</label>
                  <div className="flex gap-2">
                    {[1, 2, 3, 4, 5].map((star) => (
                      <button
                        key={star}
                        type="button"
                        onClick={() => setEditedReview({ ...editedReview, rating: star })}
                        className="transition-transform hover:scale-110"
                      >
                        <Star
                          className={`h-8 w-8 ${
                            star <= editedReview.rating
                              ? 'fill-yellow-400 text-yellow-400'
                              : 'text-gray-600'
                          }`}
                        />
                      </button>
                    ))}
                  </div>
                </div>

                <div>
                  <label className="mb-2 block text-sm text-gray-300">Review</label>
                  <textarea
                    value={editedReview.content}
                    onChange={(e) =>
                      setEditedReview({ ...editedReview, content: e.target.value })
                    }
                    className="h-40 w-full rounded-lg bg-gray-700 p-4 text-white placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-purple-500"
                    required
                  />
                </div>

                <div className="flex gap-4">
                  <button
                    type="submit"
                    className="rounded-lg bg-purple-600 px-6 py-2 font-medium text-white hover:bg-purple-700"
                  >
                    Save Changes
                  </button>
                  <button
                    type="button"
                    onClick={() => setIsEditing(false)}
                    className="rounded-lg bg-gray-700 px-6 py-2 font-medium text-white hover:bg-gray-600"
                  >
                    Cancel
                  </button>
                </div>
              </form>
            ) : (
              <>
                <div className="mb-4 flex gap-1">
                  {[...Array(5)].map((_, i) => (
                    <Star
                      key={i}
                      className={`h-6 w-6 ${
                        i < review.rating ? 'fill-yellow-400 text-yellow-400' : 'text-gray-600'
                      }`}
                    />
                  ))}
                </div>
                <p className="whitespace-pre-wrap text-gray-300">{review.content}</p>
              </>
            )}
          </div>
        </div>
      </div>
    </div>
  );
};