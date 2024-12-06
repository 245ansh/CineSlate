import React from 'react';
import { Star } from 'lucide-react';
import { Link } from 'react-router-dom';
import { HomeMovie, Movie } from '../types';



export const MovieCard: React.FC<HomeMovie> = ({ id, name, image }) => {
  return (
    <Link to={`/movie/${id}`} className="group">
      <div className="relative overflow-hidden rounded-lg bg-gray-800 transition-transform duration-300 hover:scale-105">
        <img
          src={image}
          alt={name}
          className="h-[400px] w-full object-cover"
        />
        <div className="absolute bottom-0 left-0 right-0 bg-gradient-to-t from-black to-transparent p-4">
          <h3 className="text-lg font-bold text-white">{name}</h3>
        </div>
      </div>
    </Link>
  );
}