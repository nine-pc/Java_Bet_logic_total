import {
    Card,
    CardContent,
    Typography,
    Button,
    Stack
} from "@mui/material";
import { Link } from "react-router-dom";
import type { Event } from "../../types/Event";

interface Props {
    event: Event;
}

export default function EventCard({ event }: Props) {
    return (
        <Card>
            <CardContent>

                <Typography variant="h6">
                    {event.homeTeam} vs {event.awayTeam}
                </Typography>

                <Typography color="text.secondary">
                    {new Date(event.startTime).toLocaleString()}
                </Typography>

                <Typography sx={{ mt: 1 }}>
                    Status: {event.status}
                </Typography>

                <Stack
                    direction="row"
                    justifyContent="flex-end"
                    sx={{ mt: 2 }}
                >
                    <Button
                        component={Link}
                        to={`/events/${event.id}`}
                        variant="contained"
                    >
                        Open
                    </Button>
                </Stack>

            </CardContent>
        </Card>
    );
}