import {
    Box,
    Button,
    Card,
    CardContent,
    Stack,
    Typography
} from "@mui/material";

import { Link } from "react-router-dom";

export default function Home() {
    return (
        <Box>

            <Typography variant="h3" gutterBottom>
                Welcome to Bet Logic
            </Typography>

            <Typography color="text.secondary" mb={4}>
                A simple sports betting platform built with
                Spring Boot and React.
            </Typography>

            <Stack
                direction="row"
                spacing={3}
                flexWrap="wrap"
            >

                <Card sx={{ width: 280 }}>
                    <CardContent>
                        <Typography variant="h6">
                            Browse Events
                        </Typography>

                        <Typography mt={2}>
                            View available matches and odds.
                        </Typography>

                        <Button
                            component={Link}
                            to="/events"
                            sx={{ mt: 3 }}
                            variant="contained"
                        >
                            Events
                        </Button>
                    </CardContent>
                </Card>

                <Card sx={{ width: 280 }}>
                    <CardContent>
                        <Typography variant="h6">
                            Wallet
                        </Typography>

                        <Typography mt={2}>
                            Deposit money and check balance.
                        </Typography>

                        <Button
                            component={Link}
                            to="/wallet"
                            sx={{ mt: 3 }}
                            variant="contained"
                        >
                            Wallet
                        </Button>
                    </CardContent>
                </Card>

                <Card sx={{ width: 280 }}>
                    <CardContent>
                        <Typography variant="h6">
                            My Bets
                        </Typography>

                        <Typography mt={2}>
                            View betting history.
                        </Typography>

                        <Button
                            component={Link}
                            to="/bets"
                            sx={{ mt: 3 }}
                            variant="contained"
                        >
                            My Bets
                        </Button>
                    </CardContent>
                </Card>

            </Stack>

        </Box>
    );
}