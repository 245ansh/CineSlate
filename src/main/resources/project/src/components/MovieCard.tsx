import React from 'react';
import { Star } from 'lucide-react';
import { Link } from 'react-router-dom';
import { Movie } from '../types';

interface MovieCardProps {
  movie: Movie;
}

export const MovieCard: React.FC<MovieCardProps> = ({ movie }) => {
  return (
    <Link to={`/movie/${movie.id}`} className="group">
      <div className="relative overflow-hidden rounded-lg bg-gray-800 transition-transform duration-300 hover:scale-105">
        <img
          src={movie.posterUrl}
          alt={movie.title}
          className="h-[400px] w-full object-cover"
        />
        <div className="absolute bottom-0 left-0 right-0 bg-gradient-to-t from-black to-transparent p-4">
          <h3 className="text-lg font-bold text-white">{movie.title}</h3>
          <div className="flex items-center gap-2">
            <Star className="h-4 w-4 text-yellow-400" />
            <span className="text-sm text-gray-300">{movie.rating}</span>
          </div>
        </div>
      </div>
    </Link>
  );
}