import React, { useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { Star } from 'lucide-react';

export const ReviewForm = () => {
  const { movieId } = useParams();
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    rating: 0,
    content: '',
  });

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    // Handle review submission
  };

  return (
    <div className="min-h-screen bg-gray-900 pt-20">
      <div className="mx-auto max-w-3xl px-4 py-12">
        <div className="rounded-lg bg-gray-800 p-6 shadow-xl">
          <h2 className="mb-6 text-2xl font-bold text-white">Write a Review</h2>

          <form onSubmit={handleSubmit} className="space-y-6">
            <div>
              <label className="mb-2 block text-sm text-gray-300">Rating</label>
              <div className="flex gap-2">
                {[1, 2, 3, 4, 5].map((star) => (
                  <button
                    key={star}
                    type="button"
                    onClick={() => setFormData({ ...formData, rating: star })}
                    className="transition-transform hover:scale-110"
                  >
                    <Star
                      className={`h-8 w-8 ${
                        star <= formData.rating
                          ? 'fill-yellow-400 text-yellow-400'
                          : 'text-gray-600'
                      }`}
                    />
                  </button>
                ))}
              </div>
            </div>

            <div>
              <label htmlFor="content" className="mb-2 block text-sm text-gray-300">
                Your Review
              </label>
              <textarea
                id="content"
                value={formData.content}
                onChange={(e) => setFormData({ ...formData, content: e.target.value })}
                className="h-40 w-full rounded-lg bg-gray-700 p-4 text-white placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-purple-500"
                placeholder="Share your thoughts about the movie..."
                required
              />
            </div>

            <div className="flex gap-4">
              <button
                type="submit"
                className="flex-1 rounded-lg bg-purple-600 px-4 py-3 font-medium text-white transition-colors hover:bg-purple-700"
              >
                Submit Review
              </button>
              <button
                type="button"
                onClick={() => navigate(-1)}
                className="rounded-lg bg-gray-700 px-4 py-3 font-medium text-white transition-colors hover:bg-gray-600"
              >
                Cancel
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};