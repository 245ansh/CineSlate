import React from 'react';
import { Star, User } from 'lucide-react';
import { Link } from 'react-router-dom';
import { Review } from '../types';

interface ReviewCardProps {
  review: Review;
}

export const ReviewCard: React.FC<ReviewCardProps> = ({ review }) => {
  return (
    <Link to={`/review/${review.id}`} className="group">
      <div className="rounded-lg bg-gray-800 p-4 transition-all duration-300 hover:bg-gray-700">
        <div className="mb-4 flex items-center gap-3">
          <User className="h-8 w-8 rounded-full bg-gray-600 p-1 text-gray-300" />
          <div>
            <h4 className="font-medium text-white">{review.userName}</h4>
            <p className="text-sm text-gray-400">{review.createdAt}</p>
          </div>
        </div>
        <div className="mb-3 flex items-center gap-2">
          <img
            src={review.moviePoster}
            alt={review.movieTitle}
            className="h-16 w-12 rounded object-cover"
          />
          <div>
            <h3 className="font-semibold text-white">{review.movieTitle}</h3>
            <div className="flex items-center gap-1">
              {[...Array(5)].map((_, i) => (
                <Star
                  key={i}
                  className={`h-4 w-4 ${
                    i < review.rating ? 'text-yellow-400' : 'text-gray-600'
                  }`}
                />
              ))}
            </div>
          </div>
        </div>
        <p className="line-clamp-3 text-sm text-gray-300">{review.content}</p>
      </div>
    </Link>
  );
}