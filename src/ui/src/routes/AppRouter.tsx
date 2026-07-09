import { BrowserRouter, Routes, Route } from "react-router-dom";

import MainLayout from "../components/layout/MainLayout";

import Home from "../pages/Home/Home";
import Events from "../pages/Events/Events";
import EventDetails from "../pages/EventDetails/EventDetails";

function Wallet() {
    return <h1>Wallet</h1>;
}

function Bets() {
    return <h1>My Bets</h1>;
}

function NotFound() {
    return <h1>404 NotFound</h1>;
}

export default function AppRouter() {
    return (
        <BrowserRouter>
            <Routes>
                <Route element={<MainLayout />}>
                    <Route
                        path="/"
                        element={<Home />}
                    />

                    <Route
                        path="/events"
                        element={<Events />}
                    />

                    <Route
                        path="/wallet"
                        element={<Wallet />}
                    />

                    <Route
                        path="/bets"
                        element={<Bets />}
                    />

                </Route>

                <Route
                    path="*"
                    element={<NotFound />}
                />

                <Route
                    path="/events/:id"
                    element={<EventDetails />}
                />
            </Routes>
        </BrowserRouter>
    );
}
