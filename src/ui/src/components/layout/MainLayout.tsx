import { AppBar, Box, Container, Toolbar, Typography } from "@mui/material";
import { Outlet } from "react-router-dom";

import Navbar from "./Navbar";

export default function MainLayout() {
    return (
        <Box>
            <Navbar />

            <Container sx={{ mt: 4 }}>
                <Outlet />
            </Container>
        </Box>
    );
}