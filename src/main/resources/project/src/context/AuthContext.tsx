import React, { createContext, useContext, useState, useEffect } from 'react';
import { User } from '../types';

interface AuthContextType {
  user: User | null;
  isAuthenticated: boolean;
  login: (email: string, password: string) => Promise<void>;
  register: (name: string, email: string, password: string) => Promise<void>;
  logout: () => void;
}

const AuthContext = createContext<AuthContextType | undefined>(undefined);

export const AuthProvider: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  const [user, setUser] = useState<User | null>(null);
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  useEffect(() => {
    // Check for stored auth token and validate
    const token = localStorage.getItem('authToken');
    if (token) {
      // Validate token and set user
    }
  }, []);

  const login = async (email: string, password: string) => {
    try {
      // Implement login logic
      const mockUser = {
        id: '1',
        name: 'John Doe',
        email,
        reviews: [],
        lists: [],
      };
      setUser(mockUser);
      setIsAuthenticated(true);
      localStorage.setItem('authToken', 'mock-token');
    } catch (error) {
      throw new Error('Login failed');
    }
  };

  const register = async (name: string, email: string, password: string) => {
    try {
      // Implement registration logic
      const mockUser = {
        id: '1',
        name,
        email,
        reviews: [],
        lists: [],
      };
      setUser(mockUser);
      setIsAuthenticated(true);
      localStorage.setItem('authToken', 'mock-token');
    } catch (error) {
      throw new Error('Registration failed');
    }
  };

  const logout = () => {
    setUser(null);
    setIsAuthenticated(false);
    localStorage.removeItem('authToken');
  };

  return (
    <AuthContext.Provider value={{ user, isAuthenticated, login, register, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => {
  const context = useContext(AuthContext);
  if (context === undefined) {
    throw new Error('useAuth must be used within an AuthProvider');
  }
  return context;
};