import { useState } from "react";

import {
    Button,
    Card,
    CardContent,
    Divider,
    Stack,
    TextField,
    Typography
} from "@mui/material";

import { placeBet } from "../../api/betApi";

interface Props { outcome: Outcome | null;}

export default function BetSlip({
    outcome
}: Props) {

    const [stake, setStake] = useState(0);
    const [placing, setPlacing] = useState(false);

    const potentialWin = outcome ? stake * outcome.odds : 0;

    async function handlePlaceBet() {

        if (!outcome) {
            return;
        }

        try {

            setPlacing(true);

            await placeBet({

                userId: 1,

                stake,

                outcomeIds: [selectedOutcome.id]

            });

            alert("Bet placed successfully!");

            setStake(0);

        } catch {

            alert("Unable to place bet.");

        } finally {

            setPlacing(false);

        }

    }

    return (
        <Card>
            <CardContent>
                <Typography variant="h5">
                    Bet Slip
                </Typography>

                <Divider sx={{ my: 2 }} />

                {outcome ? (
                    <>
                        <Typography variant="h6">
                            {outcome.name}
                        </Typography>

                        <Typography>
                            Odds: {outcome.odds}
                        </Typography>
                    </>
                ) : (
                    <Typography>
                        No selections
                    </Typography>
                )}

                <TextField
                    fullWidth
                    type="number"
                    label="Stake"
                    value={stake}
                    onChange={(e)=> setStake(Number(e.target.value))}
                    sx={{ mt: 3 }}
                />

                <Typography sx={{ mt: 2 }}>
                    Potential Win: {potentialWin.toFixed(2)}
                </Typography>

                <Button
                    fullWidth
                    variant="contained"
                    sx={{ mt: 3 }}
                    disabled={!outcome || stake <= 0 || placing}
                    onClick={handlePlaceBet}
                >
                    {placing ? "Placing..." : "Place Bet"}
                </Button>

            </CardContent>

        </Card>
    );
}