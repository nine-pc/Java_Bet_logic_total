import { useEffect, useState } from "react";
import { useParams} from "react-router-dom";

import {
    Alert,
    Card,
    CardContent,
    CircularProgress,
    Grid,
    Typography,
    Button
} from "@mui/material";
import { getEvents } from "../../api/eventApi";
import type { Event } from "../../types/Event";
import EventCard from "../../components/event/EventCard";



function Events() {

    const { id } = useParams();

    const [events, setEvents] = useState<Event | null>(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");

    useEffect(() => {
        loadEvents();
    }, []);

    useEffect(() => {

        if(!id) return;

        getEvents(Number(id))
            .then(setEvents);
        }, [id]);

    async function loadEvents() {
        try {
            const data = await getEvents();
            setEvents(data);
        } catch (e) {
            console.error(e);
            setError("Unable to load events.");
        } finally {
            setLoading(false);
        }
    }

    if (loading) {
        return (
            <>
                <h2>Loading</h2>
            </>
       );
    }

    return (
        <>
            <Typography variant="h4" sx={{ mb: 3 }}>
                Events
            </Typography>

            <Grid container spacing={3}>
                {events.map(event => (
                    <Grid
                        size={{ xs: 12, md: 6, lg: 4 }}
                        key={event.id}
                    >
                        <EventCard event={event} />
                    </Grid>
                ))}
            </Grid>
        </>
    );
}

export default Events;