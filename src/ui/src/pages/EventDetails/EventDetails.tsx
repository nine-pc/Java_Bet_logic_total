import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import {
    Typography,
    Card,
    CardContent,
    CircularProgress,
    Alert,
    Grid,
    Stack
} from "@mui/material";

import { getEvent } from "../../api/eventApi";
import { getMarkets } from "../../api/marketApi";

import type { Event } from "../../types/Event";
import type { Market } from "../../types/Market";

import MarketCard from "../../components/market/MarketCard";
import BetSlip from "../../components/bet/BetSlip";


export default function EventDetails() {

    const { id } = useParams();

    const [event, setEvent] = useState<Event | null>(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");
    const [markets, setMarkets] = useState<Market[]>([]);
    const [selectedOutcome, setSelectedOutcome] = useState<Outcome | null>(null);

    useEffect(() => {

        if (!id) return;

        loadEvent();

    }, [id]);

    async function loadEvent() {

        try {

            const data = await getEvent(Number(id));

            setEvent(data);

            const marketData = await getMarkets(Number(id));

            setMarkets(marketData);

        } catch {

            setError("Unable to load event.");

        } finally {

            setLoading(false);

        }

    }

    if (loading) {
        return <CircularProgress />;
    }

    if (error) {
        return <Alert severity="error">{error}</Alert>;
    }

    if (!event) {
        return <Alert severity="warning">Event not found.</Alert>;
    }

    return (
        <Grid container spacing={3}>

                <Grid size={{ xs: 12, md: 8 }}>

                    <Card>
                        <CardContent>

                            <Typography variant="h4">
                                {event.homeTeam} vs {event.awayTeam}
                            </Typography>

                            <Typography sx={{ mt: 2 }}>
                                {new Date(event.startTime).toLocaleString()}
                            </Typography>

                            <Typography sx={{ mt: 2 }}>
                                Status: {event.status}
                            </Typography>

                            <Typography variant="h5" sx={{ mt: 4, mb: 2 }}>
                                Markets
                            </Typography>

                            <Stack spacing = {2}>
                                {markets.map(market => (

                                    <MarketCard
                                        key={market.id}
                                        market={market}
                                        onSelectOutcome = {setSelectedOutcome}
                                    />

                                ))}
                            </Stack>
                        </CardContent>
                    </Card>
                </Grid>

                <Grid size={{ xs: 12, md: 4 }}>

                    <BetSlip
                        outcome = {selectedOutcome}
                    />

                </Grid>

            </Grid>
    );
}