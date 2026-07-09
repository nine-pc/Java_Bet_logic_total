import { useState, useEffect } from "react";

import {
    Card,
    CardContent,
    Typography
} from "@mui/material";

import type { Market } from "../../types/Market";
import type { Outcome } from "../../types/Outcome";

import { getOutcomes } from "../../api/outcomeApi";

import OutcomeCard from "../outcome/OutcomeCard";

interface Props {
    market: Market;
    onSelectOutcome: (outcome: Outcome) => void;
}

export default function MarketCard({ market, onSelectOutcome }: Props) {

    const [outcomes, setOutcomes] = useState<Outcome[]>([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        loadOutcomes();
    }, [market.id]);

    async function loadOutcomes() {
        try {
            const data = await getOutcomes(market.id);
            setOutcomes(data);
        } finally {
            setLoading(false);
        }
    }

    return (
        <Card sx={{ mt: 2 }}>
            <CardContent>
                <Typography variant="h6">
                    {market.name}
                </Typography>
                {outcomes.map(outcome => (
                    <OutcomeCard
                        key={outcome.id}
                        outcome={outcome}
                        onSelect={onSelectOutcome}
                    />

                ))}
            </CardContent>
        </Card>
    );
}