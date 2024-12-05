import React from 'react';
import { useAuth } from '../context/AuthContext';
import { User, Mail, Film, Star } from 'lucide-react';

export const ProfilePage = () => {
  const { user, logout } = useAuth();

  return (
    <div className="min-h-screen bg-gray-900 pt-20">
      <div className="mx-auto max-w-4xl px-4 py-12">
        <div className="rounded-lg bg-gray-800 shadow-xl">
          <div className="relative h-48 bg-gradient-to-r from-purple-900 to-blue-900">
            <div className="absolute bottom-0 left-1/2 -translate-x-1/2 translate-y-1/2">
              <div className="flex h-32 w-32 items-center justify-center rounded-full bg-gray-700 text-white">
                <User className="h-16 w-16" />
              </div>
            </div>
          </div>

          <div className="px-6 pb-6 pt-20">
            <div className="text-center">
              <h1 className="text-2xl font-bold text-white">{user?.name}</h1>
              <div className="mt-2 flex items-center justify-center gap-2 text-gray-400">
                <Mail className="h-4 w-4" />
                <span>{user?.email}</span>
              </div>
            </div>

            <div className="mt-8 grid grid-cols-1 gap-6 md:grid-cols-3">
              <div className="rounded-lg bg-gray-700 p-4 text-center">
                <Film className="mx-auto mb-2 h-6 w-6 text-purple-400" />
                <div className="text-2xl font-bold text-white">{user?.reviews.length}</div>
                <div className="text-sm text-gray-400">Reviews</div>
              </div>
              <div className="rounded-lg bg-gray-700 p-4 text-center">
                <Star className="mx-auto mb-2 h-6 w-6 text-yellow-400" />
                <div className="text-2xl font-bold text-white">4.5</div>
                <div className="text-sm text-gray-400">Avg Rating</div>
              </div>
              <div className="rounded-lg bg-gray-700 p-4 text-center">
                <Film className="mx-auto mb-2 h-6 w-6 text-blue-400" />
                <div className="text-2xl font-bold text-white">{user?.lists.length}</div>
                <div className="text-sm text-gray-400">Lists</div>
              </div>
            </div>

            <div className="mt-8 flex justify-center">
              <button
                onClick={logout}
                className="rounded-lg bg-red-600 px-6 py-2 font-medium text-white hover:bg-red-700"
              >
                Sign Out
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};