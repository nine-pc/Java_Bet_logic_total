import {
    Card,
    CardContent,
    Typography,
    Button,
    Stack
} from "@mui/material";

import type { Outcome } from "../../types/Outcome";

interface Props {
    outcome: Outcome;
    onSelect: (outcome: Outcome) => void;
}

export default function OutcomeCard({ outcome, onSelect}: Props) {

    return (
        <Card variant="outlined">

            <CardContent>

                <Stack
                    direction="row"
                    justifyContent="space-between"
                    alignItems="center"
                >

                    <Typography>
                        {outcome.name}
                    </Typography>

                    <Button
                        variant="contained"
                        onClick={() => onSelect(outcome)}
                    >
                        {outcome.odds.toFixed(2)}
                    </Button>

                </Stack>

            </CardContent>

        </Card>
    );
}